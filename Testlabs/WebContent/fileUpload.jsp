<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Product Form</title>
</head>
<body>
    <div id="global">
        <form name="product" action="save-product" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Add a product</legend>
                <p>
                    <label for="name">Product Name: </label>
                    <input id="name" path="name" cssErrorClass="error" />
                    
                </p>
                <p>
                    <label for="description">Description: </label>
                    <input id="description" path="description" />
                </p>
                <p>
                    <label for="image">Product Images: </label>
                    <input type="file" name="images" multiple="multiple"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4">
                    <input id="submit" type="submit" tabindex="5" value="Add Product">
                </p>
            </fieldset>
        </form>
    </div>
</body>
</html>