const forge = require('node-forge');
const QRCode = require('qrcode');

//function to generateKetPair
function generateKeyPair() {
    const ed25519 = forge.pki.ed25519;
    const keyPair = ed25519.generateKeyPair();
    return keyPair;
}

//function to sign the message
function signMessage(message, privateKey){
    const ed25519 = forge.pki.ed25519;
    const messageBytes = Buffer.from(message, 'utf8');
    const signature = ed25519.sign({
        message: messageBytes,
        privateKey: privateKey
    });
    return Buffer.from(signature).toString('hex');
}

//function to create a qr code
async function createQRCode(data, filePath) {
    try {
        await QRCode.toFile(filePath, data);
        console.log('QR Code created at:', filePath);
    } catch (err) {
        console.error('Error creating QR Code:', err);
    }
}
