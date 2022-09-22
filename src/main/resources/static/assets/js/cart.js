const { createApp } = Vue

createApp({
    data() {
        return {
            client: {},
            bills: {},
            currentBill: {},
            productsToDisplay: [],
        }
    },

    created() {
        this.loadClientData();

    },

    mounted() { },

    methods: {
        loadClientData() {
            axios.get('/api/clients/current')
                .then(response => {
                    this.client = response.data;
                    this.bills = this.client.bills;
                    this.currentBill = this.bills.find(bill => bill.payed == false)
                    console.log(this.currentBill);
                    this.loadProductsToDisplay()
                    console.log(this.productsToDisplay)
                })
        },

        loadProductsToDisplay() {
            this.currentBill.client_orders.forEach(clientOrder => {
                clientOrder.ordered_productDTOS.forEach(ordered_productDTO => {
                    this.productsToDisplay.push(ordered_productDTO)
                })
            });
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
        emptyCart() {
            axios.patch('/api/bill/empty/',`billId=${this.currentBill.id}`)
                .then(() => window.location.reload())
        },











        logout() {
            axios.post('/api/logout')
                .then(response => window.location.href = "./index.html")
        },


    },

    computed: {},

}).mount('#app')