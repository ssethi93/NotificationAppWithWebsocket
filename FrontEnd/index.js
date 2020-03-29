let swRegistration;

const ValidationUserReq = () => {

    if (!('PushManager' in window)) {
        throw new Error("push service not available !!");
    }

    if (!('serviceWorker' in navigator)) {
        throw new Error("No Service workers available to handle push service");
    }

}
// I added a function that can be used to register a service worker.
const registerServiceWorker = async () => {
    const swRegistration = await navigator.serviceWorker.register('serviceWorker/serviceWorker.js'); //notice the file name
    return swRegistration;
}
const requestNotificationPermission = async () => {
    const permission = await window.Notification.requestPermission();
    if (permission !== 'granted') {
        throw new Error('Permission not granted for Notification');
    }
}
const showLocalNotification = (title, body, swRegistration) => {
    const options = {
        body,
        // here you can add more properties like icon, image, vibrate, etc.
    };
    swRegistration.showNotification(title, options);
}
const onMessage = (evt) => {
    if(evt.data) {
        data = JSON.parse(evt.data);
        bodyStr = data.message + " your session number is" + data.id;
        showLocalNotification(data.title, bodyStr, swRegistration)
    }
    

}

const onError = (evt) => {
    console.log("Error", evt)
}

const onClose = (evt) => {
    console.log(evt)
}
const onOpen = (evt) => {
    console.log(evt)
}


// adding a websocket connection on page load
addEventListener('load', () => {

    wsocket = new WebSocket("ws://localhost:8080/WSPushNot/push");
    wsocket.onmessage = onMessage;
    wsocket.onerror = onError;
    wsocket.onclose = onClose;
    wsocket.onopen = onOpen;
})

const main = async () => {
    swRegistration = await registerServiceWorker();
    const permission = await requestNotificationPermission();
    ValidationUserReq();
    wsocket.send("request message");
}

