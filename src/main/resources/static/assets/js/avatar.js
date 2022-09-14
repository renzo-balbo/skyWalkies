const { createApp } = Vue


createApp({
    data() {
        return {
            clientAvatar: {},
            customAvatar:{}
            

        }
    },
    created() {
        this.loadClientData()
        console.log(this.clientAvatar)
    },
    mounted() {

    },
    methods: {
        loadClientData() {
            this.clientAvatar = {
                head: 3,
                body: 4,
                bodyColor: 2,
                face: 2,
                shoes: 1
            }
            this.customAvatar = this.clientAvatar;
            // this.drawCustomAvatar()

        },

        //ESTA FUNCION ES PARA CARGAR EL AVATAR QUE YA TIENE EL USUARIO CARGADO DESDE EL BACK
        drawAvatar() {
            let canvas = document.getElementById("myCanvas");
            let ctx = canvas.getContext("2d");
            let headImg = new Image()
            headImg.src = "../assets/img/avatarCollection/head" + this.clientAvatar.head + ".png";

            let bodyImg = new Image()
            bodyImg.src = "../assets/img/avatarCollection/body" + this.clientAvatar.body + ".png";

            let bodyColor = new Image();
            bodyColor.src = "../assets/img/avatarCollection/bodyColor" + this.clientAvatar.bodyColor + ".png";

            let face = new Image();
            face.src = "../assets/img/avatarCollection/face" + this.clientAvatar.face + ".png";

            let shoes = new Image();
            shoes.src = "../assets/img/avatarCollection/shoes" + this.clientAvatar.shoes + ".png";

            let lineArt = new Image();
            lineArt.src = "../assets/img/avatarCollection/lineArtObligatory.png";


            ctx.drawImage(bodyColor, 0, 0);
            ctx.drawImage(face, 0, 0);
            ctx.drawImage(shoes, 0, 0);
            ctx.drawImage(bodyImg, 0, 0);
            ctx.drawImage(lineArt, 0, 0);
            ctx.drawImage(headImg, 0, 0);
        },

        //ESTA FUNCION VA A DIBUJAR EL AVATAR QUE ESTE MODIFICANDO EL CLIENTE
        drawCustomAvatar() {
            let canvas = document.getElementById("myCanvas");
            let ctx = canvas.getContext("2d");
            ctx.clearRect(0,0, canvas.width, canvas.height);
            let headImg = new Image()
            headImg.src = "../assets/img/avatarCollection/head" + this.customAvatar.head + ".png";

            let bodyImg = new Image()
            bodyImg.src = "../assets/img/avatarCollection/body" + this.customAvatar.body + ".png";

            let bodyColor = new Image();
            bodyColor.src = "../assets/img/avatarCollection/bodyColor" + this.customAvatar.bodyColor + ".png";

            let face = new Image();
            face.src = "../assets/img/avatarCollection/face" + this.customAvatar.face + ".png";

            let shoes = new Image();
            shoes.src = "../assets/img/avatarCollection/shoes" + this.customAvatar.shoes + ".png";

            let lineArt = new Image();
            lineArt.src = "../assets/img/avatarCollection/lineArtObligatory.png";


            ctx.drawImage(bodyColor, 0, 0);
            ctx.drawImage(face, 0, 0);
            ctx.drawImage(shoes, 0, 0);
            ctx.drawImage(bodyImg, 0, 0);
            ctx.drawImage(lineArt, 0, 0);
            ctx.drawImage(headImg, 0, 0);
        },




    },
    computed: {

    },
}).mount('#app')
