const { createApp } = Vue


createApp({
    data() {
        return {
            productsArray: [],
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

                })
        },
        priceSortedMaxToMin(){
            this.productsArray = this.productsArray.sort((a,b)=>a.price-b.price)
            console.log(this.productArray);
        },
        priceSortedMinToMax(){
            this.productsArray = this.productsArray.sort((a,b)=>b.price-a.price)
            console.log(this.productArray);
        },

        // Esperar endpoints y hacer el addToCart
        // addToCart() {
        //     axios.post('/api/producsts/add', { name: this.renderForModal, color, type,active,stock,price,})

        // },




    },
    computed: {
        
        },
    }).mount('#app')

