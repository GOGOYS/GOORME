const container_wrap = document.querySelector("div.container-wrap");
const memo_btn = document.querySelector("div.memo-list-btn");
let swit = 0;


memo_btn?.addEventListener("click",()=>{
    if(swit >0){
        container_wrap.style.left = 1920 + 'px';
        swit = 1;
    }else{
        container_wrap.style.left = 1420 + 'px';
        swit = 0;
    }
})
