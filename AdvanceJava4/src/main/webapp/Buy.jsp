<html>
<head>
<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>

</head>
<body>
<h2 align="Center">Welcome to the T-shirt Portal</h2>
<div class="container">
  <form action="datafetch">
  <div class="row">
    <div class="col-25">
      <label for="Colour">Colour</label>
    </div>
    <div class="col-75">
      <input type="text" id="Colour " name="Colour" placeholder="Enter the Colour" required>
    </div>
  </div>
  <br>
    <div class="row">
    <div class="col-25">
      <label for="size">Size</label>
    </div>
    <div class="col-75">
      <select id="size" name="size">
      	<option value="S">S</option>
        <option value="M">M</option>
        <option value="L">L</option>
        <option value="XL">XL</option>
        <option value="XXL">XXL</option>
      </select>
    </div>
  </div>
  <br>
    <div class="row">
    <div class="col-25">
      <label for="gender">Gender</label>
    </div>
    <div class="col-75">
      <select id="gender" name="gender">
      	<option value="F">Female</option>
        <option value="M">Male</option>
        <option value="U">Unisex</option>
      </select>
    </div>
  </div>
  <br>
    <div class="row">
    <div class="col-25">
      <label for="output">Output by Prefernce</label>
    </div>
    <div class="col-75">
      <select id="output" name="output">
      	<option value="1">Sorted By Price</option>
        <option value="2">Sorted By Rating</option>
        <option value="3">Sorted by both price and Rating</option>
      </select>
    </div>
  </div>
  <br>
  <div class="row">
    <input type="submit" value="Submit">
  </div>
  </form>
</div>
</form>
</body>
</html>
