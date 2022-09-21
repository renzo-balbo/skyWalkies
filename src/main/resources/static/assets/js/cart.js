const { createApp } = Vue

createApp({
    data() {
        return {
            queryString: "",
            params: "",
            id: "",
            account: {},
            transactions: [],
            client: {},
            fromDate: "",
            toDate: "",
            //PRUEBAS ADRI//
            client: [],
            bills: {},
            clientOrder: [],
            products: [],

            productsActives:[],
        }
    },

    created() {
        this.queryString = location.search;
        this.params = new URLSearchParams(this.queryString);
        this.id = this.params.get("id");
        this.loadClient();
        this.loadClientOrders();
        this.loadProductsActive();
    },

    mounted() { },

    methods: {
        loadClient() {
            axios.get('/api/clients/current')
                .then(res => {
                    this.client = res.data;
                    this.bills = this.client.bills;
                    console.log(this.productsInCart)
                    console.log(this.client);
                    console.log(this.bills);


                })
        }, loadClientOrders() {
            axios.get('/api/clientOrder')
                .then(res => {
                    this.clientOrder = res.data;
  //                  this.clientOrderActive = this.clientOrder.filter(a=> a.delete);
                    console.log(this.clientOrder);
                })
        },loadProductsActive(){
            axios.get('/api/products/')
            .then(res => {
                this.products = res.data;
                this.productsActives = this.products.filter(a=> a.delete);
                console.log(this.productsActives);
            })
        },
        logout() {
            axios.post('/api/logout')
                .then(response => window.location.href = "./index.html")
        },


    },

    computed: {},

}).mount('#app')