const forge = require('node-forge');
const QRCode = require('qrcode');

function generateKeyPair() {
    const ed25519 = forge.pki.ed25519;
    const keyPair = ed25519.generateKeyPair();
    return keyPair;
}

function signMessage(message, privateKey){
    
}

