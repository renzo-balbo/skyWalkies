const { createApp } = Vue

createApp({
    data() {
        return {
            client: {},
            bills: [],
            currentBill: {},
            cardholder: "",
            cardNumber: "",
            thruDate: new Date(),
            cvv: 0,
            fromAccount: "",
            destinyAccount: "VIN7070"


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
                })
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

        areYouSurePay() {
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
                    this.pay()
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

        pay() {
            axios.post("https://homebankingvrubank.herokuapp.com/api/transactions/payment", {
                cardNumber: this.cardNumber,
                cardCvv: this.cvv,
                amount: this.currentBill.total,
                description: 'Purchase in SKYWALKIES',
                thruDate: this.thruDate,
                cardHolder: this.cardHolder,
                accountNumber: this.fromAccount,
                accountNumberTo: this.destinyAccount
            })
                .then(response => {
                    console.log(response)
                    axios.patch('/api/bills/payment', `idBill=${this.currentBill.id}`)
                    .then(console.log('Purchase completed successfully!'))
                    .catch(error => console.log(error))
                })
        }

    },

    computed: {},

}).mount('#app')