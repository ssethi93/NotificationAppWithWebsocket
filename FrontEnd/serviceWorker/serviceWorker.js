self.addEventListener('activate', async () => {
  // This will be called only once when the service worker is installed for first time.
  try {
  } catch (err) {
    console.log('Error', err)
  }

})

// can be used to handle push notifications
self.addEventListener('push', function(event) {
})

const showLocalNotification = (title, body, swRegistration) => {
  const options = {
    body,
    // here you can add more properties like icon, image, vibrate, etc.
  }
  swRegistration.showNotification(title, options)
}