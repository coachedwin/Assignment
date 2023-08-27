function addStudent() {
    event.preventDefault();
    const name = document.getElementById("inputName").value;
    const email = document.getElementById("inputEmail").value;
    const website = document.getElementById("inputWebsite").value;
    const imageLink = document.getElementById("inputImage").value;
    var gender = "Male"
    if (document.getElementById('female').checked == true) {
        gender = "Female"
    }
    else if (document.getElementById('male').checked == true) {
        gender = "Male"
    }

    var skills = "";
    if (document.getElementById('checkboxJava').checked == true) {
        skills += "Java";
    }

    if (document.getElementById('checkboxHtml').checked == true) {
        if (skills != "") {
            skills += ",";
        }
        skills += "HTML"
    }
    if (document.getElementById('checkboxCss').checked == true) {
        if (skills != "") {
            skills += ",";
        }
        skills += "CSS";
    }

    var ele = document.getElementById("id-card-list");

    var li = document.createElement("li");
    ele.appendChild(li);

    var listcardb = document.createElement("div");
    li.appendChild(listcardb);
    listcardb.classList.add("myidborder");

    var listcarda = document.createElement("div");
    li.appendChild(listcarda);
    li.classList.add("ul");
    listcarda.classList.add("row");

    var listcard = document.createElement("div");
    ele.appendChild(listcard);
    listcard.classList.add("col-sm-8");
    listcard.classList.add("border-right-id");

    listcarda.appendChild(listcard);

    var liMain = document.createElement("ul");
    liMain.classList.add("description");
    listcard.appendChild(liMain);

    var info = document.createElement("info");
    liMain.appendChild(info);

    var liSub1 = document.createElement("li");
    liSub1.classList.add("details");
    var name1 = document.createTextNode(name);
    

    var bo = document.createElement('b');
    liSub1.appendChild(bo);

    bo.appendChild(name1);
    info.appendChild(liSub1);

    var liSub4 = document.createElement("li");
    liSub4.classList.add("details");
    var gender1 = document.createTextNode(gender);
    liSub4.appendChild(gender1);
    info.appendChild(liSub4);

    var liSub2 = document.createElement("li");
    liSub2.classList.add("details");
    var email1 = document.createTextNode(email);
    liSub2.appendChild(email1);
    info.appendChild(liSub2);

    var liSub3 = document.createElement("li");
    var sublink = document.createElement("a")
    liSub3.classList.add("details");
    var web1 = document.createTextNode(website);
    sublink.href = website;
    sublink.target = "_blank";
    liSub3.appendChild(sublink);
    sublink.appendChild(web1);
    info.appendChild(liSub3);

    var liSub5 = document.createElement("li");
    liSub5.classList.add("details");
    var skills1 = document.createTextNode(skills);
    liSub5.appendChild(skills1);
    info.appendChild(liSub5);

    var listcard2 = document.createElement("div");
    ele.appendChild(listcard2);
    listcard2.classList.add("col-sm-4");
    // listcard.classList.add("border-right-id");

    var img = document.createElement("img");
    img.src = imageLink;
    listcard2.appendChild(img);

    listcarda.appendChild(listcard2);

    // liMain.appendChild(listcard2);

}

function validation() {
    // event.preventDefault();
    var user = document.getElementById('inputName').value;

    var emails = document.getElementById('inputEmail').value;

    var website = document.getElementById('inputWebsite').value;

    var image = document.getElementById('inputImage').value;


    if (user == "") {
        document.getElementById('username').innerHTML = " ** Please fill the username field";
        return false;
    }
    if ((user.length <= 2) || (user.length > 20)) {
        document.getElementById('username').innerHTML = " ** Username length must be between 2 and 20";
        return false;
    }
    if (!isNaN(user)) {
        document.getElementById('username').innerHTML = " ** only characters are allowed";
        return false;
    }

    if (emails == "") {
        document.getElementById('emailids').innerHTML = " ** Please fill the email id field";
        return false;
    }
    if (emails.indexOf('@') <= 0) {
        document.getElementById('emailids').innerHTML = " ** @ Invalid";
        return false;
    }

    if ((emails.charAt(emails.length - 4) != '.') && (emails.charAt(emails.length - 3) != '.')) {
        document.getElementById('emailids').innerHTML = " ** . Invalid";

        return false;
    }
    if (website == "") {
        document.getElementById('webspan').innerHTML = " ** Please fill the website URL";
        return false;
    }
    if (image == "") {
        document.getElementById('imagespan').innerHTML = " ** Please fill the Image URL";
        return false;
    }
    else if (isNaN(user) || (user.length > 2)) {
        document.getElementById('username').innerHTML = "";
        document.getElementById('emailids').innerHTML = "";
        document.getElementById('webspan').innerHTML = "";
        document.getElementById('imagespan').innerHTML = "";
        addStudent();

    }

}

function myclear(){
   console.log("hi");
    document.getElementById("inputName").value="";
    document.getElementById("inputEmail").value="";
    document.getElementById("inputWebsite").value="";
    document.getElementById("inputImage").value="";
    document.getElementById("male").checked=true;
    document.getElementById("female").checked=false;
    document.getElementById('checkboxJava').checked = true;
    document.getElementById('checkboxHtml').checked = false;
    document.getElementById('checkboxCss').checked = false;
}