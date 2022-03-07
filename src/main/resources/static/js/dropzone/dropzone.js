
  Dropzone.options.myGreatDropzone = { // camelized version of the `id`
    paramName: "file", // The name that will be used to transfer the file
    maxFilesize: 5, // MB
    uploadMultiple : false,
    maxFiles: 1,
    acceptedFiles: "image/*,application/pdf,.docx, .doc",
    addRemoveLinks: true,
    accept: function(file, done) {
      if (file.name == "justinbieber.jpg") {
        done("Naha, you don't.");
      }
      else { done(); }
    }
  };
