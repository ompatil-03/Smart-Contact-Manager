//Getting current Theme
let currentTheme=getTheme();
console.log(currentTheme);
// console.log(currentTheme);
//run initially to set perticuler theme to page 
document.addEventListener("DOMContentLoaded",()=>{
    if (!sessionStorage.getItem("pageLoaded")) {
        // If pageLoaded is not set, it means this is the first load
        onFirstLoad();
        // Set the flag in sessionStorage
        sessionStorage.setItem("pageLoaded", "true");
    } else {
        console.log("Page reloaded or revisited in the same session.");
    }
   
    changeTheme();
});

//Function will only run when page is first loaded 
function onFirstLoad() {
    console.log("Page loaded for the first time!");
    document.querySelector("html").classList.remove("light");
    document.querySelector("html").classList.remove("Dark");
    setTheme(currentTheme=="Dark"?"light":"light");
   
}


//function for changing theme
function changeTheme(){
    document.querySelector("html").classList.add(currentTheme);

    const changeThemeButton=document.querySelector("#theme_changing_button");
    //changing buttong text initially
    // console.log("The current theme is "+currentTheme);
    changeThemeButton.querySelector("span").textContent=currentTheme=="light"?"Dark":"Light";
    changeThemeButton.addEventListener("click",()=>{
        let oldTheme=currentTheme;
        //changing the theme 
        if(currentTheme==="dark"){
            currentTheme="light";
        }else{
            currentTheme="dark";
        }
        //and setting it in local storage
        setTheme(currentTheme);
         //removing the current theme
         if(oldTheme){
            // console.log("removing the old theme "+oldTheme);
            document.querySelector("html").classList.remove(oldTheme);
         }
        
        //and adding the new theme
        document.querySelector("html").classList.add(currentTheme);
        //changing button text on click 
        changeThemeButton.querySelector("span").textContent=currentTheme=="light"?"Dark":"Light";
    }); 
}

//function of getting theme
function getTheme(){
   let theme= localStorage.getItem("theme");
   return theme?theme:"Light";
}

//function of setting theme
function setTheme(currentTheme){
    localStorage.setItem("theme",currentTheme);
}









