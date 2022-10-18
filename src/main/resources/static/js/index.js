// Função Alternar Light/Dark Mode

var toggle = document.getElementById("theme-toggle");

var storedTheme = localStorage.getItem('theme') || (window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light");
if (storedTheme)
    document.documentElement.setAttribute('data-theme', storedTheme)


toggle.onclick = function() {
    var currentTheme = document.documentElement.getAttribute("data-theme");
    var targetTheme = "light";

    if (currentTheme === "light") {
        targetTheme = "dark";
    }

    document.documentElement.setAttribute('data-theme', targetTheme)
    localStorage.setItem('theme', targetTheme);
};

// Verificações Front-End Form Registro

var userAge = document.getElementById('iID').value;


if(userAge < 16){
    console.log("Menó");
    document.getElementById('outputAge').textContent("Sua idade está abaixo do aceitável pelos Termos de Uso.")   
}

else{
    console.log("Maió");
    
}