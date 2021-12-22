

function findById(id) {
    return document.getElementById(id);
} 

function loadForm() {
    return {
        name: findById("activity-name").value,
        type: findById("activity-type").value,
        difficulty: findById("activity-difficulty").value,
        description: findById("activity-description").value,
    }
}

function clearForm() {
    findById("activity-name").value = null;
    findById("activity-type").value = null;
    findById("activity-difficulty").value = null;
    findById("activity-description").value = null;
}

function assertUserLoggedIn() {
    return axios.get("api/custom/user")
        .then(user => console.log(user))
        .catch(err => window.location.href = "/login");
}

function saveForm() {
    let form = loadForm();
    axios.post("api/custom/activities", form)
        .then(resp => {
            console.log(JSON.stringify(resp));
            alert("success!");
            clearForm();
        })
        .catch(err => alert(JSON.stringify(err)));
}


assertUserLoggedIn();