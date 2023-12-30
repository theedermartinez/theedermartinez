function buttontopress(){
    let colorIndex = ["#27844e","#4952eb","#6f1b35","#fdf277","#fd712e"]
    const x = Math.floor(Math.random() * 5);
    document.getElementById("bodyback").style.backgroundColor = colorIndex[x];
}

function randomButton2Press(){ 
    let color = "#"

    while(color.length < 7){
        let letterOrNumber = ["n","l"];
        let number = Math.floor(Math.random()*2);
        let letterOrNumberPick = letterOrNumber[number];
        if (letterOrNumberPick == "n"){
            let generateNumber = Math.floor(Math.random()*10);
            color = color + generateNumber
        } 
        else{
            let letterList = ["a","b","c","d","e","f"];
            let letterNum = Math.floor(Math.random()*6);
            let generateLetter = letterList[letterNum];
            color = color + generateLetter;
        }
    }3
    console.log(color)
    document.getElementById("colorhex").innerHTML = color
    document.getElementById("bodyback").style.backgroundColor = color;

}