<template>
  <div id="app">
    <editor
      api-key="no-api-key"
      initialValue=""
      :init="{
         height: 500,
         menubar: false,
         plugins: [
           'advlist autolink lists link image charmap print preview anchor',
           'searchreplace visualblocks code fullscreen',
           'insertdatetime media table paste code help wordcount'
         ],
         toolbar:
           'undo redo | formatselect | bold italic backcolor | \
           alignleft aligncenter alignright alignjustify | \
           bullist numlist outdent indent | removeformat | help'
       }"
    ></editor>
  </div>
</template>

 <script>
import Editor from "@tinymce/tinymce-vue";

export default {
  name: "app",
  data() {
    return {
      text : ""
    }
  },
  components: {
    editor: Editor
  },
  methods: {
    get() {
      this.text = tinyMCE.activeEditor.getContent();
      return this.text;
    },
    set(str) {
      tinyMCE.activeEditor.setContent(str)
      this.text = tinyMCE.activeEditor.getContent();
    }
  }
};
</script>