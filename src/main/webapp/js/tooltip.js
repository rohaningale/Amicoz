$(function () {
    $(document).tooltip({
        content: function () {
            return $(this).prop('title');
        },
        show: null, 
        close: function (event, ui) {
            ui.tooltip.hover(
            function () {
                $(this).stop(true).fadeTo(400, 1);
            },
            function () {
                $(this).fadeOut("400", function () {
                    $(this).remove();
                })
            });
        },
        position: {
        my: "right-15 center",
        at: "left center",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
});