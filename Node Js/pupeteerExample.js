const puppeteer = require("puppeteer");

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  const random = Math.floor(Math.random() * 1000000 + 1);
  // await page.goto("https://www.google.com");
  await page.setContent(`<html>

    <body>
        <center>
            <h1>Insert Data</h1>
            <form action="/api/app-insert" method="POST">
                <table border="0">
                    <tr>
                        <td>
                            Object Id :
                        </td>
                        <td>
                            <input type="text" placeholder="Object Id" name="OBJ_ID">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Html Content :
                        </td>
                        <td>
                            <textarea cols="30" rows="10" placeholder="Html Content" name="HTML_CONTENT"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Program Id :
                        </td>
                        <td>
                            <input type="text" placeholder="Program Id" name="PROGRAM_ID">
                        </td>
                    </tr>
                    <tr>
                        <td colspan=" 2" align="center" style="padding-top: 10px;">
                            <input type="submit" value="Insert Data">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>

</html>`);

  await page
    .screenshot({ path: ".\\ScreenShots\\" + random + ".jpeg" })
    .catch((errr) => {
      console.log(err);
    });

  await browser.close();
})();
