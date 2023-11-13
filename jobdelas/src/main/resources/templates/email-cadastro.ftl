<!DOCTYPE html>
<html>
  <head>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
      }

      .container {
        margin: 0 auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      .header,
      .footer {
        background-color: #b378ff;
        color: #ffffff;
        text-align: center;
        padding: 20px 0;
      }

      .footer {
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }
      h1 {
        color: #ffffff;
        font-size: 24px;
        margin: 0;
      }

      main {
        padding: 20px;
      }

      p {
        color: #333;
        font-size: 16px;
      }

      strong {
        color: #b378ff;
      }

      .footer img {
        width: 150px;
      }

      h3 {
        font-size: 18px;
        margin: 0;
      }

      h2 {
        font-size: 24px;
      }

      .centralizarimg {
        display: block;
        margin: 0 auto;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <div class="header">
        <h1>Olá, ${nome}!</h1>
      </div>
      <main>
        <p>
          Seja muito bem-vinda ao <strong>Job Delas</strong>, a rede social de
          emprego feita especialmente para mulheres como você!
        </p>
        <p>
          Estamos felizes em informar que a sua conta foi cadastrada com
          sucesso.
        </p>
        <p>
          Obrigado por escolher o Job Delas para impulsionar a sua carreira!
        </p>
        <p>
          Se surgir alguma dúvida ou se precisar de assistência, não hesite em
          entrar em contato conosco. Estamos aqui para ajudar!
        </p>
      </main>
    </div>

    <div class="footer">
      <h3 style="text-align: center">Atenciosamente,</h3>
      <div style="text-align: center">
        <img
          src="https://heravendas.s3.us-east-005.backblazeb2.com/produtos/3/logo.png"
          alt="Logo do JobDelas"
          class="centralizarimg"
        />
      </div>
    </div>
  </body>
</html>
