const { createApp } = Vue


createApp({
    data() {
        return {
            clientEmail:"",
            clientPassword:"",
            newClientFirstName:"",
            newClientLastName:"",
            newClientEmail:"",
            newClientPassword:"",
            productsArray: [],
            upperShelf:[],
            middleShelf:[],
            bottomShelf:[],
            renderForModal: "",
            priceToDisplay: "",
            stockToDisplay: "",
            productToDisplay: {},

        }
    },
    created() {
        // this.arrayZapatillas.push("NIKE-LV-LOW_04", "LV-NIKE-AFONE-HIGH-PLUS-A3")
        this.loadProducts()
    },
    mounted() {

    },
    methods: {
        changeRender(productName) {
            this.renderForModal = productName;
            this.productToDisplay = this.productsArray.find(product => product.name == productName)

        },
        nameFormater(productName) {
            productName = productName.replace(/-/g, " ")
            productName = productName.replace(/_/g, " ")
            return productName;
        },
        moneyFormatter(numberToFormat) {
            let formatter = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: 'USD',
            })
            return formatter.format(numberToFormat)
        },
        loadProducts() {
            axios.get('/api/products')
                .then(response => {
                    this.productsArray = response.data
                    console.log(this.productsArray);
                    this.productsArray.forEach(product => product.price = this.moneyFormatter(product.price))
                    this.priceSortedMaxToMin()
                    this.priceSortedMinToMax()
                    this.shelvesFiller()
                    console.log(this.upperShelf);
                    console.log(this.middleShelf);
                    console.log(this.bottomShelf);

                })
        },
        shelvesFiller(){
            this.upperShelf = this.productsArray.slice(0,14)
            this.middleShelf = this.productsArray.slice(14,32)
            this.bottomShelf = this.productsArray.slice(32,47)
        },
        priceSortedMaxToMin(){
            this.productsArray = this.productsArray.sort((a,b)=>a.price-b.price)
            this.upperShelf = this.upperShelf.sort((a,b)=>a.price-b.price)
            this.middleShelf = this.middleShelf.sort((a,b)=>a.price-b.price)
            this.bottomShelf = this.bottomShelf.sort((a,b)=>a.price-b.price)
            console.log(this.upperShelf);


        },
        priceSortedMinToMax(){
            this.productsArray = this.productsArray.sort((a,b)=>b.price-a.price)
            this.upperShelf = this.upperShelf.sort((a,b)=>b.price-a.price)
            this.middleShelf = this.middleShelf.sort((a,b)=>b.price-a.price)
            this.bottomShelf = this.bottomShelf.sort((a,b)=>b.price-a.price)

        },

        // Esperar endpoints y hacer el addToCart
        // addToCart() {
        //     axios.post('/api/producsts/add', { name: this.renderForModal, color, type,active,stock,price,})

        // },

        login() {
            axios.post("/api/logout")
            .then(()=>{
                axios.post("/api/login", `email=${this.clientEmail}&password=${this.clientPassword}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    console.log(response)
                    // window.location.href = ""
                })
                .catch(error => {
                    swal("There was an error with your email or password. Please try again.",{
                        dangerMode:true
                    });
                    console.log("Error:",error.response.status,"Code:",error.code)
                })
            })

        },

        signUp() {
            axios.post('/api/clients', `firstName=${this.newClientFirstName}&lastName=${this.newClientLastName}&email=${this.newClientEmail}&password=${this.newClientPassword}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
            .then(response => console.log(response))
            .catch(error =>{
                console.log(error)
                console.log("Error:",error.response.status,"Code:", error.code, error.response.data)
                if(error.response.data == "This email belongs to an existing client"){
                    swal(error.response.data,".",{
                        dangerMode:true
                    })
                } else {
                    swal("Please fill all the required fields.",{
                        dangerMode:true
                    });
                }
            })
        },



    },
    computed: {
        
        },
    }).mount('#app')

