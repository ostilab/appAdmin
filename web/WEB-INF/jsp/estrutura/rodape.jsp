<%-- 
    Document   : rodape
    Created on : 23/ago/2016, 10:58:15
    Author     : len
--%>
 <hr>
<footer>
    <div class="container">
    
            <div class="row">
                <p class="text-center">Copyright © 2016 Todos os direitos reservados <a href="http://ostiinvestimentos.com"> OSTI Investimentos </a></p>
            </div>
        </div>
   
</footer>
<script>
    var main = function () {

        /* Push the body and the nav over by 285px over */

        $('.icon-menu').click(function () {

            $('.icon-menu i').hide();

            $('.menu').animate({
                left: "0px"

            }, 200);



            /*$('.jumbotron_a').animate({
             
             left: "285px"
             
             }, 200);*/

        });


        /* Then push them back */

        $('.icon-close').click(function () {
            $('.icon-menu i').show();
            $('.menu').animate({
                left: "-285px"

            }, 200);

            /*
             $('body').animate({
             
             left: "0px"
             
             }, 200);*/

        });

    };



    $(document).ready(main);
</script>
</body>
</html>
