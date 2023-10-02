<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" class="h-100" data-bs-theme="auto">
<head>
    <title>Quest</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="cache-control" content="max-age=0"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

    <script type="text/javascript">
        window.onload = function () {
            if (sessionStorage.getItem('hasCodeRunBefore') === null) {
                $('#prologueModal').modal('show');
                sessionStorage.setItem("hasCodeRunBefore", true);
            }
        };

        function hideModal() {
            $('#prologueModal').modal('hide');
            sessionStorage.setItem("hasCodeRunBefore", true);
        }
    </script>
</head>

<body class="d-flex h-100 text-center text-bg-dark">
<div class="modal fade" id="prologueModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                <button onclick=hideModal() type="button" class="close btn-modal-prologue-close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5" id="prologueText" style="color: grey">
                <p>Приключения кота Батона</p>
                <p>Персонажи: кот Батон</p>
                <p>Жанр: сказка</p>
                <p>Невероятные приключения кота Батона!</p>
                <p>Сможет ли кот Батон найти свою еду?</p>
                <p>Введите свое имя в поле ниже...</p>
            </div>
            <table>
                <form method="post">
                    <td class="fs-5 mt-1 mb-1">
                        <input type="text" id="player_name" name="player_name" class="form-control"
                               aria-describedby="passwordHelpBlock">
                    </td>
                    <td class="fs-5 mt-1 mb-1">
                        <button onclick="/start" type="submit" class="btn btn-primary" id="btn-save-player-name">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-floppy2-fill" viewBox="0 0 16 16">
                                <path d="M12 2h-2v3h2V2Z"/>
                                <path d="M1.5 0A1.5 1.5 0 0 0 0 1.5v13A1.5 1.5 0 0 0 1.5 16h13a1.5 1.5 0 0 0 1.5-1.5V2.914a1.5 1.5 0 0 0-.44-1.06L14.147.439A1.5 1.5 0 0 0 13.086 0H1.5ZM4 6a1 1 0 0 1-1-1V1h10v4a1 1 0 0 1-1 1H4ZM3 9h10a1 1 0 0 1 1 1v5H2v-5a1 1 0 0 1 1-1Z"/>
                            </svg>
                        </button>
                    </td>
                </form>
            </table>
            <div class="modal-footer">
                <button onclick=hideModal() type="button" class="btn btn-secondary btn-modal-prologue-close"
                        data-dismiss="modal">Закрыть
                </button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="statisticModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header" style="color: grey">
                <h4 class="modal-title">Статистика</h4>
                <button onclick=$('#statisticModal').modal('hide') type="button" class="close btn-modal-victory-close"
                        data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body fs-5" style="color: grey">
                <p>Количество игр: ${gamesCount}</p>
                <p>Имя игрока: ${playerName}</p>
            </div>
            <div class="modal-footer">
                <button onclick=$('#statisticModal').modal('hide') type="button"
                        class="btn btn-secondary btn-modal-victory-close" data-dismiss="modal">Закрыть
                </button>
            </div>
        </div>
    </div>
</div>

<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
    </symbol>
</svg>

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="mb-auto">
        <div>
            <nav class="nav nav-masthead justify-content-center float-md-end">
                <button onclick=$('#statisticModal').modal('show'); type="button" class="nav-link fw-bold py-1 px-0"
                        data-dismiss="modal">Статистика
                </button>
            </nav>
        </div>
    </header>

    <main class="px-3">
        <p class="lead">${question.getQuestionText()}</p>
        <c:set value="${question.checkWin()}" var="isWinQuestion"/>
        <c:choose>
            <c:when test="${question.checkWin() eq false}">
                <c:forEach var="i" items="${buttons}">
                    <div class="btn-group me-4" role="group">
                        <a href="/logic?button=${buttons.indexOf(i)}"
                           class="btn btn-lg btn-light fw-bold border-white bg-white">${i}</a>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <a href="/restart" class="btn btn-lg btn-light fw-bold border-white bg-white">начать с начала</a>
            </c:otherwise>
        </c:choose>
    </main>

    <footer class="mt-auto text-white-50">
        <p>The original <a href="https://endless-stories.ru/cat-baton-story.html" class="text-white">story</a>, by <a
                href="https://vk.com/maria_mgan" class="text-white">Maria Mgan</a>.</p>
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

</body>
</html>
