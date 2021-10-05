/**
 * 
 */

let readTable = document.querySelector("#read");
let readBtn = document.querySelector("#read-btn");


let noOfLp = document.querySelector(".no-laptop");
let close = document.querySelector(".close");

let allData = document.querySelectorAll(".allData");
const dataBox= (e)=>{
	for(let i of allData){
		if(e.target.classList[0]==i.classList[0]){
			
			i.nextElementSibling.classList.toggle("hide-data");
			
			i.nextElementSibling.classList.toggle("laptop-data");
			
		}		
		
	}
	
		console.log(e.target.closest("#empLapBox"))
		e.target.closest("#empLapBox").classList.add("hide-data");
		e.target.closest("#empLapBox").classList.remove("laptop-data");
		
	

	
}

document.addEventListener("click",dataBox);
close.addEventListener("click",(e)=>{
			console.log(e.target.closest("#empLapBox"))
			console.log(e.target)
			e.target.closest("#empLapBox").classList.toggle("hide-data");
			
			e.target.closest("#empLapBox").classList.toggle("laptop-data");
});
	




console.log("hello")

/*	document.querySelector("tr").insertAdjacentHTML("afterend",markupTable); */  	

/*
console.log(document.querySelector("#empLapBox").getData("id"));
noOfLp.addEventListener("click",dataBox);
readBtn.addEventListener("click",function(e){
	e.preventDefault();
	readTable.classList.remove("hide-data");
	
	console.log("click");
	fetch("http://localhost:8080/CRUDProj/CRUDProj/hello/read").then(response=>response.json()).then(data=>console.log(data))
		
})
	console.log(data);

	window.location = "CRUDProj/hello/read"
	event.returnValue=true;
*/