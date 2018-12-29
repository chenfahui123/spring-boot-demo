(function () {
    var $ = layui.jquery;

    $('#upload').click(function () {
        $.ajax({
            url: '/file/upload',
            method: 'post',
            data: $('#file').val()
        })
    })
})();