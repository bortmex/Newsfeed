$(function () {

    function successNoty(key) {
        iziToast.show({
            color: 'green',
            position: 'bottomRight',
            timeout: 2000,
            message: "Новость записана"
        });
    }
    successNoty('common.saved');

});