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

