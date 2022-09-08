<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<body>



<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign Up</button>

<div id="id01" class="modal">

    <form class="modal-content animate" action="signUpUser" method="post">


        <div class="container">

            <input type="text" placeholder="Enter Username" name="login" required>
        <br><br>

            <input type="password" placeholder="Enter Password" name="password" required>


            <button type="submit">Register</button>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>

        </div>
    </form>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign In </button>

<div id="id02" class="modal">

    <form class="modal-content animate" action="signInUser">


        <div class="container">

            <input type="text" placeholder="Enter Username" name="login" required>
            <br><br>
            <input type="password" placeholder="Enter Password" name="password" required>

            <button type="submit">Login</button>



        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>

        </div>
    </form>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('id02');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</body>
</html>


