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

            //NEW PRODUCTS DATA
            newProductName: "",
            newProductColor: "",
            newProductPrice: "",
            newStatus: false,
            newProductSizes: [],
            newStock: "",


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



        toggleProductActive(product) {
            switch (product.active) {
                case true:
                    product.active = false;
                    break;
                case false:
                    product.active = true;
                    break;
                default:
                    product.active=true
            }
            console.log(product.active);
        },

        //Productos nuevos

        changeNewStatus() {
            switch (this.newStatus) {
                case true:
                    this.newStatus = false;
                    break;
                case false:
                    this.newStatus = true;
                    break;
                default:
                    this.newStatus = false;
            }
            console.log(this.newStatus);
        },

        addNewSizes(newSize) {
            if (this.newProductSizes.includes(newSize)) {
                let indexToRemove = this.newProductSizes.indexOf(newSize)
                this.newProductSizes.splice(indexToRemove, 1)
            } else if (!this.newProductSizes.includes(newSize)) {
                this.newProductSizes.push(newSize)
            }
            console.log(this.newProductSizes);
        },

        stringToArray(stringToConvert) {
            let string = stringToConvert;
            let array = string.split(',');
            return array
        },

        addNewProduct() {
            axios.post('/api/products/add', { name: this.newProductName, shoeColors: this.stringToArray(this.newProductColor), type: 'Sneaker', active: this.newStatus, sizes: this.newProductSizes, stock: this.newStock, price: this.newProductPrice })
                .then(response => {
                    swal(response.data)
                    window.location.reload()

                    console.log("Product added")
                })
                .catch(error => console.log(error))
        },


        logout() {
            axios.post("/api/logout")
                .then(() => {
                    window.location.reload()
                })
        }



    },
    computed: {
    },
}).mount('#app')

