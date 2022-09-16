const { createApp } = Vue


createApp({
    data() {
        return {
            clientAvatar: {},
            customAvatar:{},
            avatarHead: new Image(),
            avatarBody: new Image(),
            avatarBodyColor: new Image(),
            avatarFace: new Image(),
            avatarShoes: new Image(),
            avatarArtLine: new Image(),
        }
    },
    beforeCreate(){
        console.log("before create")
    },
    created() {
        console.log("created")
        this.loadClientData()
    },

    beforeMount(){
        console.log("before mount")
    },

    mounted() {
        this.prepareAvatarParts();
        this.drawAvatar();
        console.log("mounted")
    },

    beforeUpdate(){
        this.avatarHead.src="../assets/img/avatarCollection/head"+this.customAvatar.head+".png";
        this.avatarBody.src="../assets/img/avatarCollection/body"+this.customAvatar.body+".png";
        this.avatarBodyColor.src="../assets/img/avatarCollection/bodyColor"+this.customAvatar.bodyColor+".png";
        this.avatarFace.src="../assets/img/avatarCollection/face"+this.customAvatar.face+".png";
        this.avatarShoes.src="../assets/img/avatarCollection/shoes"+this.customAvatar.shoes+".png";
        this.avatarArtLine.src="../assets/img/avatarCollection/lineArtObligatory.png";
        console.log("before update")
    },

    updated(){
        console.log("updated")
        this.drawCustomAvatar()
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


        },

        //ESTA FUNCION ES PARA CARGAR EL AVATAR QUE YA TIENE EL USUARIO CARGADO DESDE EL BACK
        drawAvatar() {
            let canvas = document.getElementById("myCanvas");
            let ctx = canvas.getContext("2d");

            ctx.drawImage(this.avatarBodyColor, 0, 0);
            ctx.drawImage(this.avatarFace, 0, 0);
            ctx.drawImage(this.avatarShoes, 0, 0);
            ctx.drawImage(this.avatarBody, 0, 0);
            ctx.drawImage(this.avatarArtLine, 0, 0);
            ctx.drawImage(this.avatarHead, 0, 0);
        },

        //ESTA FUNCION VA A DIBUJAR EL AVATAR QUE ESTE MODIFICANDO EL CLIENTE
        drawCustomAvatar() {
            let canvas = document.getElementById("myCanvas");
            let ctx = canvas.getContext("2d");

            ctx.clearRect(0,0, canvas.width, canvas.height);
            
            ctx.drawImage(this.avatarBodyColor, 0, 0);
            ctx.drawImage(this.avatarFace, 0, 0);
            ctx.drawImage(this.avatarShoes, 0, 0);
            ctx.drawImage(this.avatarBody, 0, 0);
            ctx.drawImage(this.avatarArtLine, 0, 0);
            ctx.drawImage(this.avatarHead, 0, 0);
        },


        prepareAvatarParts(){
            this.avatarHead.src="../assets/img/avatarCollection/head"+this.clientAvatar.head+".png";
            this.avatarBody.src="../assets/img/avatarCollection/body"+this.clientAvatar.body+".png";
            this.avatarBodyColor.src="../assets/img/avatarCollection/bodyColor"+this.clientAvatar.bodyColor+".png";
            this.avatarFace.src="../assets/img/avatarCollection/face"+this.clientAvatar.face+".png";
            this.avatarShoes.src="../assets/img/avatarCollection/shoes"+this.clientAvatar.shoes+".png";
            this.avatarArtLine.src="../assets/img/avatarCollection/lineArtObligatory.png";
        },

        updateAvatarParts(){
            this.avatarHead.src="../assets/img/avatarCollection/head"+this.customAvatar.head+".png";
            this.avatarBody.src="../assets/img/avatarCollection/body"+this.customAvatar.body+".png";
            this.avatarBodyColor.src="../assets/img/avatarCollection/bodyColor"+this.customAvatar.bodyColor+".png";
            this.avatarFace.src="../assets/img/avatarCollection/face"+this.customAvatar.face+".png";
            this.avatarShoes.src="../assets/img/avatarCollection/shoes"+this.customAvatar.shoes+".png";
            this.avatarArtLine.src="../assets/img/avatarCollection/lineArtObligatory.png";
        },



    },
    computed: {


    },
}).mount('#app')