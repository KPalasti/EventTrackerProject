console.log("script.js loaded");

window.addEventListener('load', function(e) {
	console.log('document loaded');
	console.log('testing from atom');
	init();
});

function init() {
	console.log('In init()');
	//TODO - setup event listeners for forms etc.
 document.liftForm.lookup.addEventListener('click', function(event) {
    event.preventDefault();
    var liftId = document.liftForm.liftId.value;
    if (!isNaN(liftId) && liftId > 0) {
      getLift(liftId);
    }
  });
}

document.newLiftForm.addLift.addEventListener(('click'), function(evt) {
	evt.preventDefault();
	let f = document.newLiftForm;
	//let f = evt.target.parentElement; ANOTHER OPTION
	let newLift = {
		name: f.name.value
	};
	//newFilm.title = f.title.value; ANOTHER OPTION
	createLift(newLift);
});

function getLift(liftId) {
  // TODO:
  // * Use XMLHttpRequest to perform a GET request to "api/films/"
  //   with the filmId appended.
  // * On success, if a response was received parse the film data
  //   and pass the film object to displayFilm().
  // * On failure, or if no response text was received, put "Film not found" 
  //   in the filmData div.
  
  let xhr = new XMLHttpRequest();
  xhr.open('GET', 'api/lifts/' + liftId);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let lift = JSON.parse(xhr.responseText);
        console.log(lift);
        displayLift(lift);
      } else if(xhr.status === 404) {
        displayError("Lift " + liftId + " not found.");
      }
      else {
        console.error('Request failed!');
      }
    }
  }
xhr.send(); console.log('XHR request sent');
}

function displayError(msg) {
 var dataDiv = document.getElementById('liftData');
 dataDiv.textContent = msg;
}
function displayLift(lift) {
  var dataDiv = document.getElementById('liftData');
  dataDiv.textContent = '';
  // TODO:
  // * Create and append elements to the data div to display:
  // * Film title (h1) and description (blockquote).
  // * Rating, release year, and length as an unordered list.
  
  let h1 = document.createElement('h1');
  h1.textContent = lift.name;
  dataDiv.appendChild(h1);
  //let desc = document.createElement('blockquote');
  //desc.textContent = f.description;
  //dataDiv.appendChild(desc);
  //TODO ADD Unordered List of * Rating, release year, and length as an unordered list.
  let ul = document.createElement('ul');
  dataDiv.appendChild(ul);
  
  //let li = document.createElement('li');
  //li.textContent = "Rating :" +film.rating;
  //ul.appendChild(li);
  
  //li = document.createElement('li');
  //li.textContent = "Release year: " + film.releaseYear;
  //ul.appendChild(li);
  
  //li = document.createElement('li');
  //li.textContent = "Film length: " + film.length;
  //ul.appendChild(li);
}

function createLift(newLift){
	console.log(newLift);
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/lifts')
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) {
			if(xhr.status === 201 || xhr.status === 200){
				let lift = JSON.parse(xhr.responseText);
				displayLift(lift);
			}
			else {
				console.error('Lift create failed with status: ' + xhr.status);
			}
		}
		
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newLift));
}
