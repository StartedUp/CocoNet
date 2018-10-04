/**
 * Created by root on 4/10/18.
 */
function messageAlertModal(title, message) {
    $('#messageTitle').text(title)
    $('#alertMessage').text(message)
    $('#messageModal').modal('show')
}
