const { createApp } = Vue


createApp({
    data() {
        return {
            arrayZapatillas: [],
            renderForModal: "",
        }
    },
    created() {
        this.arrayZapatillas.push("NIKE-LV-LOW_04", "LV-NIKE-AFONE-HIGH-PLUS-A3")
        
    },
    mounted() {

    },
    methods: {
        changeRender(productName) {
            this.renderForModal = productName;
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



    },
    computed: {


    },
}).mount('#app')

const slider = document.getElementById("slider");
const scrollContainer = document.getElementsByClassName("sliderForGallery")
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
    } else {
        slider.scrollLeft -= 100
    }
});