@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h2>Users List</h2>

        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя!</p>
        @else
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
    `,
    footer = @`
        <p>Alina Tarasova</p>
        <p><a href="https://github.com/funnyDevGirl">My GitHub profile</a></p>
    `
)