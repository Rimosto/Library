<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Search Results</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Availability</th>
        </tr>
        <%
            ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
            for(Book book : books) {
        %>
            <tr>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getGenre() %></td>
                <td><%= book.isAvailable() ? "Available" : "Borrowed" %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
