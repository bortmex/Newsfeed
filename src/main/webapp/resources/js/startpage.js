var ajaxUrl = 'ajax/getall';

function makeEditable1() {

    updatePresentationNews();

    $('#applyfilter').click(function () {
        document.body.classList.remove("is-menu-visible");
        var categorid = $('#selectpicker').children(":selected").attr("id");
        var namesearch = document.getElementById('name').value ;
        var contentsearch = document.getElementById('content').value ;

        if(categorid==="nocategory_empty")
            updatePresentationNewsWithFilterWithOutId(namesearch, contentsearch);
        else updatePresentationNewsWithFilter(categorid, namesearch, contentsearch);
        return false;
    });

    $('#canselfilter').click(function () {
        updatePresentationNews();
        document.body.classList.remove("is-menu-visible");
        document.getElementById('name').value = '';
        document.getElementById('content').value = '';
        document.getElementById('selectpicker').value = 'Все категории';
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        $("#help1").text("");
        $("#help2").text("");
        $("#help3").text("");
        try {
            var textError = jqXHR.responseJSON.split("<br>");
            for(var i = 0; i<textError.length-1; i++){
                var textLocalErr = textError[i];
                if(textLocalErr.split(" ")[0]==="description") $("#help3").text(textLocalErr.substring(12, textLocalErr.length));
                else if(textLocalErr.split(" ")[0] === "name") {if(textLocalErr.split(" ")[1]==="null") $("#help1").text(i18n['products.datetime.duplicate']); else $("#help1").text(textLocalErr.substring(5, textLocalErr.length));}
                else if(textLocalErr.split(" ")[0] === "price") $("#help2").text(textLocalErr.substring(6, textLocalErr.length));
            }
        }catch (error){
            /*failNoty(event, jqXHR, options, jsExc);*/
        }
    })
}

function updatePresentationNews() {
    $.get(ajaxUrl, function(data) {
        getAll(data);
    });
}

function updatePresentationNewsWithFilter(id, name, content) {
    $.get("ajax/getallfiltercategories/" + id + "/name" + name + "/content" + content, function(data) {
        getAll(data);
    });
}

function updatePresentationNewsWithFilterWithOutId(name, content) {
    $.get("ajax/getallfiltercategorieswithoutid/name" + name + "/content" + content, function(data) {
        getAll(data);
    });
}

function getAll(data) {
    var div = document.getElementById('main');
    var presentation_of_all_news="";
    $("#post").remove();
    $('#main').html('');
    $.each(data, function (key, value) {
        presentation_of_all_news +=
        "        <article class=\"post\">" +
        "            <header>" +
        "                <div class=\"title\">" +
        "                    <h2><a style='cursor: default'>" +value.name+"</a></h2>" +
        "                    <p>Категория: " +value.categories.name +"</p>" +
        "                </div>" +
        "                <div class=\"meta\">" +
        "                    <time class=\"published\">"+getMounth(value.datacreate)+"</time>" +
        "                </div>" +
        "            </header>" +
        "            <p>"+value.content+"</p>" +
        "            <footer>" +
        "                <ul class=\"actions\">\n" +
        "                    <li><a href='getnews/"+value.id+"' class=\"button big\">Редактировать</a></li>" +
        "                    <li><a onclick= deleteNews("+value.id+") class=\"button big\">Удалить</a></li>" +
        "                </ul>" +
        "            </footer>" +
        "        </article>";
    });
    div.innerHTML += presentation_of_all_news;
}

function successNoty(value) {
    iziToast.show({
        color: 'green',
        position: 'bottomRight',
        timeout: 2000,
        message: value
    });
}

function getMounth(str) {
    var mounth = ['января','февраля','март','апреля','май','июня','июля','августа','сентября','октября','ноября','декабря'];
    var number = parseInt(str.substring(5,7));
    return str.substring(8,10) +' '+ mounth[number] + ' '+ str.substring(0,4);
}

function deleteNews(id) {
    $.ajax({
        url: "ajax/deletenews/" + id,
        type: 'DELETE',
        success: function () {
            updatePresentationNews();
            successNoty("Новость удалена");
        }
    });
}

$(function () {
    makeEditable1();
});