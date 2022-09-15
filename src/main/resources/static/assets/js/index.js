const { createApp } = Vue


createApp({
    data() {
        return {
            isDown:Boolean,
            
        }
    },
    created() {
    },
    mounted() {

    },
    methods: {


    },
    computed: {

    },
}).mount('#app')

const slider = document.getElementById("slider");
let isDown = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', (e) => {
    isDown = true;
    slider.classList.add('active');
    startX = e.pageX - slider.offsetLeft;
    scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', () => {
    isDown = false;
    slider.classList.remove('active');
});
slider.addEventListener('mouseup', () => {
    isDown = false;
    slider.classList.remove('active');
});
slider.addEventListener('mousemove', (e) => {
    if (!isDown) return;
    e.preventDefault();
    const x = e.pageX - slider.offsetLeft;
    const walk = (x - startX) * 3; //scroll-fast
    slider.scrollLeft = scrollLeft - walk;
    console.log(walk);
});

window.addEventListener("wheel", (e) => {
    if (e.deltaY > 0) {
        slider.scrollLeft += 100
    }else{
     slider.scrollLeft -= 100}
  });