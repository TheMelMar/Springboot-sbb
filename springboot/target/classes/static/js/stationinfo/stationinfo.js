function returnText(){
    let input = document.getElementById("userInput").value;
    window.open("http://localhost:8088/trainInfo?id=" + input);
}
