$(document).ready(function() {
    alert("salam");
    // When the form is submitted
    $("#article-form").submit(function(event) {
        // Prevent the form from submitting normally
        event.preventDefault();

        // Get the form data
        var formData = {
            title: $("#title").val(),
            description: $("#description").val(),
            content: $("#content").val()
        };

        // Submit the form using Ajax
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/articles",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function(data) {
                // Clear the form inputs
                $("#title").val("");
                $("#description").val("");
                $("#content").val("");

                // Refresh the article list
                refreshArticleList();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("Error adding article: " + textStatus);
            }
        });
    });

    // Function to refresh the article list
    function refreshArticleList() {
        $.get("/articles", function(data) {
            // Remove the existing articles from the table
            $("#article-table tbody").empty();

            // Add the new articles to the table
            $.each(data, function(index, article) {
                $("#article-table tbody").append("<tr><td>" + article.title + "</td><td>" + article.description + "</td><td>" + article.content + "</td></tr>");
            });
        });
    }

    // Load the article list when the page is loaded
    refreshArticleList();
});


function sendRequest(myArray) {
    j.ajax({


    })


}

function add(){
    let newTitle = jquery("#title").val.trim;
    let newDescription = jquery("#description").val.trim;
    let newContent = jquery("#content").val.trim;
    let myArray = [newTitle, newDescription, newContent];
    if(myArray){
        sendRequest(myArray);
    }
}
