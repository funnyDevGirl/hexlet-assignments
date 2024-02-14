@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div class="container">

        <h2>Users List</h2>

        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя!</p>
            <a href="/">Back</a>
        @else
            <form action="/users" method="get">
                <label>
                    <input class="nav-link" type="search" name="term" value="${page.getTerm()}">
                </label>
                <input class="nav-link" type="submit" value="Search">
            </form>

            <table>
                <thead>
                <tr>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                    </tr>
                @endfor
                </tbody>
            </table>
        @endif
    </div>
`
)