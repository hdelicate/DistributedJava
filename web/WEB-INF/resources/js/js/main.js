function validateEntry() {
  var x = document.forms["pikeDetails"]["pikeEntry"].value;
  if (x == "") {
    alert("Must enter new details");
    return false;
  }
}
