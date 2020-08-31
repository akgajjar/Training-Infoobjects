import React from "react";
import ReactDOM, { render } from "react-dom";
// Jsx
ReactDOM.render(
  <div>
    <h1> Hello World</h1>
    <p>THis is a Paragraph</p>
  </div>,
  document.getElementById("root")
);


var myNewp = document.createElement("p");
myNewp.innerHTML = "This is a Paragraph";