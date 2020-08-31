const posts = [
  { title: "Post One", body: "This is Post One" },
  { title: "Post Two", body: "This is Post Two" },
];
function getPosts() {
  setTimeout(() => {
    let output = "";
    posts.forEach((post) => {
      output += `<li>${post.title}</li>`;
    });
    document.body.innerHTML = output;
  }, 1000);
}

function createPost(post) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      posts.push(post);

      const error = false;

      if (!error) {
        resolve();
      } else {
        reject("Error : something went wrong");
      }
    }, 2000);
  });
}

//Async /Await

async function init() {
  await createPost({ title: "Post Three", body: "This is a Post Three" });
  getPosts();
  await fetchusers();
}

init();

// Async Await with fetch

async function fetchusers() {
  const res = await fetch("https://jsonplaceholder.typicode.com/users");
  const data = await res.json();

  console.log(data);
}
