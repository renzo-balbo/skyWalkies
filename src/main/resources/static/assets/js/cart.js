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

        remoteItemFromCart(itemToRemove){
            axios.patch('/api/ordered_product/remove',`orderedProductId=${itemToRemove.id}&billId=${this.currentBill.id}`)
            .then(response => console.log(response))
            .catch(error => console.log(error.response))
        },











        logout() {
            axios.post('/api/logout')
                .then(response => window.location.href = "./index.html")
        },
        areYouSure() {
            let swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-light m-2',
                    cancelButton: 'btn btn-light m-2'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Are you sure?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: '¡Yes!',
                cancelButtonText: '¡Cancel!',
                color: 'white',
                background: 'black',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    this.logout()
                } else if (
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire({
                        title: 'Great!',
                        text: "Let's keep walking in the sky",
                        icon: 'success',
                        color: 'white',
                        background: 'black',
                        showConfirmButton: false
                    })

                }
            })
        },
        areYouSureEmpty() {
            let swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-light m-2',
                    cancelButton: 'btn btn-light m-2'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Are you sure?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: '¡Yes!',
                cancelButtonText: '¡Cancel!',
                color: 'white',
                background: 'black',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    this.emptyCart()
                } else if (
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire({
                        title: 'Great!',
                        text: "Let's buy it then!",
                        icon: 'success',
                        color: 'white',
                        background: 'black',
                        showConfirmButton: false
                    })

                }
            })
        },

    },

    computed: {},

}).mount('#app')