
var ips = ["10.0.1.183", "10.0.1.53", "10.0.1.221", "10.0.1.48"];
var endpoints = ["/", "/login", "/test", "/blah"];
function getRandomElement(arr){
	return arr[Math.floor(Math.random()*arr.length)];
}
setInterval(function(){console.log(getRandomElement(ips) + " " + (Date.now()) +" "+ getRandomElement(endpoints) + " 404");}, 100);

