
const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:3004';

const headers = {
    'Accept': 'application/json'
};

export const getUserActivity = () =>
    fetch(`${api}/activity`,{
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    }).then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });
