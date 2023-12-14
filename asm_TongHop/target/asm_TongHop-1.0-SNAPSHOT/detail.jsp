<%@ include file="theme/navbar.jsp"%>
<div class="container mt-3">
    <div class="d-flex">
        <h3 style="flex:1">${video.title}</h3>
        <div>
           <%-- Chỉ hiển thị nút Like và Unlike khi đã  login thành công--%>
               <c:if test="${not empty sessionScope.username}">
                   <!-- Hiển thị nút "Like" và "Unlike" chỉ khi đã đăng nhập -->
                   <a href="insert-favorite?id=${video.id}" class="btn btn-sm border-primary" >Like</a>
                   <a href="delete-favorite?id=${video.id}" class="btn btn-sm border-primary" >Unlike</a>
               </c:if>
        </div>
    </div>
    <%--Nhúng video theo yêu cầu của youtobe--%>
    <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${video.id}"  allowfullscreen></iframe>
</div>

<%--<script>--%>
<%--    function likeVideo(videoId) {--%>
<%--        // Gửi yêu cầu đến servlet để thêm video vào danh sách yêu thích--%>
<%--        // Sử dụng Ajax hoặc chuyển hướng trang tùy vào yêu cầu của bạn--%>
<%--        // Ví dụ sử dụng Ajax:--%>
<%--        var xhr = new XMLHttpRequest();--%>
<%--        xhr.open('POST', 'insert-favorite', true);--%>
<%--        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');--%>
<%--        xhr.onload = function() {--%>
<%--            // Xử lý kết quả từ server nếu cần--%>
<%--            if (xhr.status === 200) {--%>
<%--                console.log('Video liked successfully.');--%>
<%--            } else {--%>
<%--                console.error('Failed to like video.');--%>
<%--            }--%>
<%--        };--%>
<%--        xhr.send('videoId=' + encodeURIComponent(videoId));--%>
<%--    }--%>
<%--</script>--%>

<%--<script>--%>
<%--    function unlikelikeVideo(videoId) {--%>
<%--        // Gửi yêu cầu đến servlet để thêm video vào danh sách yêu thích--%>
<%--        // Sử dụng Ajax hoặc chuyển hướng trang tùy vào yêu cầu của bạn--%>
<%--        // Ví dụ sử dụng Ajax:--%>
<%--        var xhr = new XMLHttpRequest();--%>
<%--        xhr.open('POST', 'delete-favorite', true);--%>
<%--        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');--%>
<%--        xhr.onload = function() {--%>
<%--            // Xử lý kết quả từ server nếu cần--%>
<%--            if (xhr.status === 200) {--%>
<%--                console.log('Video liked successfully.');--%>
<%--            } else {--%>
<%--                console.error('Failed to like video.');--%>
<%--            }--%>
<%--        };--%>
<%--        xhr.send('videoId=' + encodeURIComponent(videoId));--%>
<%--    }--%>
<%--</script>--%>
