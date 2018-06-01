//$(document).ready(function() {
//  $('form').submit(function(event) {
//
//    var formData = {
//      'email': $('input[name=email]').val(),
//      'email2': $('input[name=email2]').val()
//    };
//
//    $.ajax({
//        url: "http://localhost:8080/admin/matchResult",
//        data: formData,
//        type: "POST",
//        dataType: "json",
//        contentType: "application/json; charset=utf-8",
//      })
//      .done(function(data) {
//        console.log(data);
//      });
//    event.preventDefault();
//  });
//});

var xhr = new XMLHttpRequest();
var url = "http://localhost:8080/admin/matchResult";
xhr.open("POST", url, true);
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
        console.log(json.email + ", " + json.email2);
    }
};
var data = JSON.stringify({"email": "hey@mail.com", "email2": "hey2@mail.com"});
xhr.send(data);
