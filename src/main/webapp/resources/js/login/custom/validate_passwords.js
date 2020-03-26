var password = document.getElementById("password")
    , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
    if(password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;


function CheckPassword()
{
    var password = document.getElementById("password");
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    if(!password.value.match(passw))
    {
        confirm_password.setCustomValidity("Password must consist of min 6 symbols, 1 digit and 1 uppercase letter");
        return false;
    }
}