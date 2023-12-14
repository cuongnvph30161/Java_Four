<%-- Created by IntelliJ IDEA. User: Admin Date: 11/4/2023 Time: 4:47 PM To
change this template use File | Settings | File Templates. --%>
<%@ page
        contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Form Demo</title>
</head>
<body>
<form>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Full name</label>
        <input required name="name"
               type="email"
               class="form-control"
               id="exampleInputEmail1"
               aria-describedby="emailHelp"
        />
    </div>

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Gender</label>
        <div class="form-check">
            <input required
                   class="form-check-input"
                   type="radio"
                   name="gender"
                   id="flexRadioDefault1"
            />
            <label class="form-check-label" for="flexRadioDefault1"> Male </label>
        </div>
        <div class="form-check">
            <input
                    class="form-check-input"
                    type="radio"
                    name="gender"
                    id="flexRadioDefault2"
                    checked
            />
            <label class="form-check-label" for="flexRadioDefault2">
                Female
            </label>
        </div>

    </div>

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Languages know</label>
        <div class="form-check">
            <input required class="form-check-input" type="checkbox" value="" name="language">
            <label class="form-check-label">
                English
            </label>
        </div>
        <div class="form-check">
            <input required class="form-check-input" type="checkbox" value="" name="language">
            <label class="form-check-label">
                Hindi
            </label>
        </div>
        <div class="form-check">
            <input required class="form-check-input" type="checkbox" value="" name="language">
            <label class="form-check-label">
                French
            </label>
        </div>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Country</label>
        <select class="form-select" aria-label="Default select example" name="country">
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="UK">UK</option>
            <option value="Finland">Finland</option>
            <option value="Fiji">Fiji</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
