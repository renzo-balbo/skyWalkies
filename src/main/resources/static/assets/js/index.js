const { createApp } = Vue


createApp({
    data() {
        return {
            //CLIENT DATA
            clientEmail: "",
            clientPassword: "",
            newClientFirstName: "",
            newClientLastName: "",
            newClientEmail: "",
            newClientPassword: "",
            confirmNewClientPassword: "",
            currentClient: null,
            // AVATAR
            avatar: {},
            avatarHead: new Image(),
            avatarBody: new Image(),
            avatarBodyColor: new Image(),
            avatarFace: new Image(),
            avatarShoes: new Image(),
            avatarArtLine: new Image(),
            //PRODUCTS DATA
            productsArray: [],
            upperShelf: [],
            middleShelf: [],
            bottomShelf: [],
            renderForModal: "",
            priceToDisplay: "",
            stockToDisplay: "",
            productToDisplay: {},
            shoeColors: [],
            //FILTERS
            selectedColor: [],
            // newUpperShelf:[],
        }
    },
    created() {
        this.loadData()
    },

    beforeMount() {
    },

    mounted() {
    },

    beforeUpdate() {
    },

    updated() {

    },
    methods: {

        loadData() {
            this.loadProducts()
            this.loadClientData()
        },

        loadClientData() {
            axios.get("/api/clients/current")
                .then(response => {
                    this.currentClient = response.data
                    this.avatar = this.currentClient.avatar
                    console.log(this.currentClient.avatar)
                })
                .catch(error => {
                    console.log(error)
                    this.currentClient = null
                })
        },

        // AVATAR

        prepareAvatarParts() {
            this.avatarHead.src = "../assets/img/avatarCollection/head" + this.currentClient.avatar.head + ".png";
            this.avatarBody.src = "../assets/img/avatarCollection/body" + this.currentClient.avatar.body + ".png";
            this.avatarBodyColor.src = "../assets/img/avatarCollection/bodyColor" + this.currentClient.avatar.bodyColor + ".png";
            this.avatarFace.src = "../assets/img/avatarCollection/face" + this.currentClient.avatar.face + ".png";
            this.avatarShoes.src = "../assets/img/avatarCollection/shoes" + this.currentClient.avatar.shoes + ".png";
            this.avatarArtLine.src = "../assets/img/avatarCollection/lineArtObligatory.png";
        },

        drawAvatar() {
            let canvas = document.getElementById("myCanvas");
            let ctx = canvas.getContext("2d");
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            ctx.drawImage(this.avatarBodyColor, 0, 0);
            ctx.drawImage(this.avatarFace, 0, 0);
            ctx.drawImage(this.avatarShoes, 0, 0);
            ctx.drawImage(this.avatarBody, 0, 0);
            ctx.drawImage(this.avatarArtLine, 0, 0);
            ctx.drawImage(this.avatarHead, 0, 0);
        },

        renderAvatar() {
            this.prepareAvatarParts()
            this.drawAvatar()
        },


        // FIN DEL AVATAR



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
                    this.productsArray.forEach(product => product.price = this.moneyFormatter(product.price))
                    this.priceSortedMaxToMin()
                    this.priceSortedMinToMax()
                    this.shelvesFiller()
                    this.loadShoeColors(this.productsArray)
                })
        },
        shelvesFiller() {
            this.upperShelf = this.productsArray.slice(0, 14)
            this.middleShelf = this.productsArray.slice(14, 32)
            this.bottomShelf = this.productsArray.slice(32, 47)
        },
        // FILTERS 



        priceSortedMaxToMin() {
            this.productsArray = this.productsArray.sort((a, b) => a.price - b.price)
            this.upperShelf = this.upperShelf.sort((a, b) => a.price - b.price)
            this.middleShelf = this.middleShelf.sort((a, b) => a.price - b.price)
            this.bottomShelf = this.bottomShelf.sort((a, b) => a.price - b.price)
        },

        priceSortedMinToMax() {
            this.productsArray = this.productsArray.sort((a, b) => b.price - a.price)
            this.upperShelf = this.upperShelf.sort((a, b) => b.price - a.price)
            this.middleShelf = this.middleShelf.sort((a, b) => b.price - a.price)
            this.bottomShelf = this.bottomShelf.sort((a, b) => b.price - a.price)
        },

        loadShoeColors(shoeArray) {
            this.shoeColors
            shoeArray.forEach(shoe => {
                shoe.shoeColors.forEach(color => {
                    if (!this.shoeColors.includes(color)) {
                        this.shoeColors.push(color)
                    }
                })
            })
        },

        filterByColor() {
            let newUpperShelf = []
            this.selectedColor.forEach(color => {
                this.upperShelf.forEach(shoe => {
                    if (shoe.shoeColors.includes(color)) {
                        if (!newUpperShelf.includes(shoe)) {
                            newUpperShelf.push(shoe);
                        }
                    }
                })

            })
            console.log(newUpperShelf)
            this.upperShelf = newUpperShelf;







            // this.middleShelf = this.middleShelf.filter(shoe => shoe.color == this.selectedColor)
            // this.bottomShelf = this.bottomShelf.filter(shoe => shoe.color == this.selectedColor)
        },

        changeSelectedColors(selectedColor) {
            if (this.selectedColor.filter(color => color == selectedColor).length > 0) {
                let indexToRemove = this.selectedColor.indexOf(selectedColor)
                this.selectedColor.splice(indexToRemove, 1)
                console.log(this.selectedColor, 'sacando')
            } else if (this.selectedColor.filter(color => color == selectedColor).length == 0) {
                this.selectedColor.push(selectedColor)
                console.log(this.selectedColor)
            }
            console.log('ejecutando funcion')
        },


        // END FILTERS





        // Esperar endpoints y hacer el addToCart
        // addToCart() {
        //     axios.post('/api/producsts/add', { name: this.renderForModal, color, type,active,stock,price,})

        // },

        login() {

            axios.post("/api/login", `email=${this.clientEmail}&password=${this.clientPassword}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    console.log(response)
                    window.location.reload();
                })
                .catch(error => {
                    swal("There was an error with your email or password. Please try again.", {
                        dangerMode: true
                    });
                    console.log("Error:", error.response.status, "Code:", error.code)
                })
            // })

        },

        signUp() {
            axios.post('/api/clients', `firstName=${this.newClientFirstName}&lastName=${this.newClientLastName}&email=${this.newClientEmail}&password=${this.newClientPassword}&confirmPassword=${this.confirmNewClientPassword}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => console.log(response))
                .catch(error => {
                    console.log(error)
                    console.log("Error:", error.response.status, "Code:", error.code, error.response.data)
                    if (error.response.data == "This email belongs to an existing client") {
                        swal(error.response.data, ".", {
                            dangerMode: true
                        })
                    } else {
                        swal("Please fill all the required fields.", {
                            dangerMode: true
                        });
                    }
                })
        },

        logout() {
            axios.post("/api/logout")
                .then(() => {
                    window.location.reload()
                })
        }



    },
    computed: {
        filtering() {
            if (this.selectedColor.length == 0) {
                this.upperShelf = this.productsArray.slice(0, 14)
                this.middleShelf = this.productsArray.slice(14, 32)
                this.bottomShelf = this.productsArray.slice(32, 47)
            } else if (this.selectedColor.length > 0) {
                this.filterByColor()
                console.log('filtering')
            }
        }
    },
}).mount('#app')

