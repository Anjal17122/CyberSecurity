function validatePassword() {
  let password = document.getElementById("password").value;
  let cPassword = document.getElementById("cPassword").value;

  let caseValidation = document.getElementById("epassword_Upper_Lower_Case");
  let lengthValidation = document.getElementById("epassword_char_length");
  let specialCharValidation = document.getElementById("epassword_special_char");
  let numValidation = document.getElementById("epassword_num");

  let errorpassword = document.getElementById("epassword");
  errorpassword.innerHTML = "";
  let errorcPassword = document.getElementById("ecPassword");

  let pasValidation = true;

  const brTags = document.getElementsByTagName("br");
  const brArray = Array.from(brTags);
  brArray.forEach((br) => br.remove());

  const lowerCase = new RegExp("(?=.*[a-z])");
  const upperCase = new RegExp("(.*[A-Z].*)");


  if (lowerCase.test(password) && upperCase.test(password)) {
    caseValidation.innerHTML = "";
  } else {
    pasValidation = false;
    caseValidation.innerHTML = "Should contain UpperCase and LowerCase Letter";
    caseValidation.insertAdjacentHTML("afterend", "</br>");
  }

  if (/\d/.test(password)) {
    numValidation.innerHTML = "";
  } else {
    pasValidation = false;
    numValidation.innerHTML = "Should Contain Numbers";
    numValidation.insertAdjacentHTML("afterend", "</br>");
  }

  if (/[^\w\s]/.test(password)) {
    specialCharValidation.innerHTML = "";
  } else {
    pasValidation = false;
    specialCharValidation.innerHTML = "Should Contain Special Characters.";
    specialCharValidation.insertAdjacentHTML("afterend", "</br>");
  }

  if (password.length > 8) {
    lengthValidation.innerHTML = "";
  } else {
    pasValidation = false;
    lengthValidation.innerHTML = "Should Contain min. 8 Characters";
    lengthValidation.insertAdjacentHTML("afterend", "</br>");
  }

  if (password == cPassword) {
    errorcPassword.innerHTML = "";
  } else {
    errorcPassword.innerHTML = "Password Doesn't Match";
    pasValidation = false;
  }
  return pasValidation;
}

function validateForm() {
  let validation = true;
  let fullname = document.getElementById("fullname").value;
  let username = document.getElementById("username").value;
  let email = document.getElementById("email").value;
  let phoneNumber = document.getElementById("phoneNumber").value;
  let password = document.getElementById("password").value;
  let cPassword = document.getElementById("cPassword").value;

  let errorcPassword = document.getElementById("ecPassword");
  let errorpassword = document.getElementById("epassword");
  let errorphoneNumber = document.getElementById("ephoneNumber");
  let errorEmail = document.getElementById("eemail");
  let errorFullname = document.getElementById("efullname");
  let errorUsername = document.getElementById("eusername");

  if (fullname == "") {
    errorFullname.innerHTML = "Please Enter Full Name";
    console.log("Full name is blank");
    validation = false;
  } else {
    errorFullname.innerHTML = "";
  }

  if (username == "") {
    errorUsername.innerHTML = "Please Enter Username";
    validation = false;
  } else {
    errorUsername.innerHTML = "";
  }

  if (email == "") {
    errorEmail.innerHTML = "Please Enter valid email";
    validation = false;
  } else {
    errorEmail.innerHTML = "";
  }

  if (phoneNumber == "") {
    errorphoneNumber.innerHTML = "Please Enter phoneNumber";
    validation = false;
  } else {
    errorphoneNumber.innerHTML = "";
  }

  if (password == "") {
    errorpassword.innerHTML = "Please Enter Password";
    validation = false;
  } else {
    errorpassword.innerHTML = "";
  }
  return validation;
}

let passwordTextChange = document.getElementById("password");
let confirmPasswordTextChange = document.getElementById("cPassword");
passwordTextChange.addEventListener("input", function () {
  validatePassword();
});

confirmPasswordTextChange.addEventListener("input", function () {
    validatePassword();
  });

const form = document.getElementById("myForm");
form.addEventListener("submit", function (event) {
  event.preventDefault(); // prevent form submission
  console.log("Inside form");
  if (validateForm()) {
    if(validatePassword()){
    form.submit();
    }
  }
  // all fields are valid, submit the form
  event.preventDefault();
});
