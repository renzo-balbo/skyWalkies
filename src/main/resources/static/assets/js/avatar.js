// const { createApp } = Vue


// createApp({
//     data() {
//         return {
//             avatarHead:new Image(),

//         }
//     },
//     created() {
//         // this.loadAvatarData();
//         // this.drawCanvas(this.avatarHead)
//     },
//     mounted() {

//     },
//     methods: {

//         loadAvatarData(){
//             var avatarHead = new Image()
//             let avatarHeadName = "head3.png"
//             avatarHead.src = "../assets/img/avatarCollection/"+avatarHeadName;
//             this.avatarHead.src="../assets/img/avatarCollection/head3.png";
//         },

//         drawCanvas(headToLoad){
//             let canvas = document.getElementById("myCanvas");
//             let ctx = canvas.getContext("2d");
//             let head = headToLoad;
//             ctx.drawImage(head, 10, 10);
//         }

        
//     },
//     computed: {

//     },
// }).mount('#app')

let avatar= {
    head:3,
    body:4,
    bodyColor:2,
    face:2,
    shoes:1,
}

function myCanvas() {
    let c = document.getElementById("myCanvas");
    let ctx = c.getContext("2d");
    let headImg = new Image()
    headImg.src = "../assets/img/avatarCollection/head"+avatar.head+".png";
    
    let bodyImg = new Image()
    bodyImg.src="../assets/img/avatarCollection/body"+avatar.body+".png";

    let bodyColor = new Image();
    bodyColor.src="../assets/img/avatarCollection/bodyColor"+avatar.bodyColor+".png";

    let face = new Image();
    face.src="../assets/img/avatarCollection/face"+avatar.face+".png";

    let shoes= new Image();
    shoes.src="../assets/img/avatarCollection/shoes"+avatar.shoes+".png";

    let lineArt = new Image();
    lineArt.src="../assets/img/avatarCollection/lineArtObligatory.png";


    ctx.drawImage(bodyColor,0,0);
    ctx.drawImage(face,0,0);
    ctx.drawImage(shoes,0,0);
    ctx.drawImage(bodyImg,0,0);
    ctx.drawImage(lineArt,0,0);
    ctx.drawImage(headImg,0,0);
}